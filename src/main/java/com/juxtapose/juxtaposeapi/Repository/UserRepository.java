    package com.juxtapose.juxtaposeapi.Repository;

    import com.juxtapose.juxtaposeapi.Utils.CommonConstants.ApiConstants;
    import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
    import com.juxtapose.juxtaposeapi.model.RequestModels.JuxtaposeUserRequest;
    import com.juxtapose.juxtaposeapi.repositoryAPI.IUserRepository;
    import lombok.extern.slf4j.Slf4j;
    import org.apache.logging.log4j.util.Strings;
    import org.springframework.dao.DataAccessException;
    import org.springframework.http.HttpStatus;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
    import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
    import org.springframework.stereotype.Repository;
    import org.springframework.util.ObjectUtils;
    import org.springframework.util.StringUtils;

    import java.util.List;
    import java.util.Objects;
    import java.util.Optional;
    import java.util.stream.Stream;

    @Repository
    @Slf4j
    public class UserRepository implements IUserRepository {

       private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
       private final RepositoryUtil repositoryUtil;
       ApiConstants apiConstants;
        private String ID_check = "";
        private String first_name_check = "";
        private String last_name_check = "";
        private String email_check = "";
        private String phone_check = "";
        private String query_add = "";
        private List<JuxtaposeUser> juxtaposeUsersList;

        public UserRepository(JdbcTemplate jdbcTemplate,
                              RepositoryUtil repositoryUtil) {
            this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            this.repositoryUtil = repositoryUtil;
        }

        @Override
        public List<JuxtaposeUser> getAllUser() throws Exception {
            log.debug("Entering getAllUser");

            try {
                List<JuxtaposeUser> result = namedParameterJdbcTemplate.query(apiConstants.getUserDataSql,
                        (rs, rowName) -> repositoryUtil.buildJuxtaposeUser(rs, rowName));
                return result;

            } catch (Exception e) {
                 throw new Exception("Received Exception from repository");
            }

        }

        @Override
        public List<JuxtaposeUser> getUsersById(Integer Id) throws DatabasePropertyViolationException {

            if(Id == null) {
                log.info("No Id received to fetch user");
            }
            MapSqlParameterSource mappedParameters = new MapSqlParameterSource();
            mappedParameters.addValue("id", Id);

            try {
                List<JuxtaposeUser> getUserListById = namedParameterJdbcTemplate.
                        query(apiConstants.getUsersById,
                                mappedParameters,
                                (rs, rowNum) -> repositoryUtil.buildJuxtaposeUser(rs, rowNum));


                log.info(apiConstants.getUsersById);
                return getUserListById;

            } catch (DataAccessException exe) {
                throw  new DatabasePropertyViolationException("Error occurred while fetching data for user via ID", exe, HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        @Override
        public Optional<List<JuxtaposeUser>> getUserByGlobalSearch(JuxtaposeUserRequest juxtaposeUserRequest) throws DatabasePropertyViolationException {
            log.info(" Starting getUserByGlobalSearch");

            Optional<JuxtaposeUserRequest> myCollections = Stream.of(juxtaposeUserRequest).filter(Objects::nonNull).findFirst();

            this.resetAllVAlues();
            myCollections.filter(val -> {

                if (null != val.getId()) {
                    ID_check = "id=" + val.getId();
                }
                if (!ObjectUtils.isEmpty(val.getFirst_name())) {
                    first_name_check = " AND " + "first_name=" + "\"" + val.getFirst_name() + "\"";
                }
                if (!ObjectUtils.isEmpty(val.getLast_name())) {
                    last_name_check = " AND " + "last_name=" + "\"" + val.getLast_name() + "\"";
                }
                if (!ObjectUtils.isEmpty(val.getEmail())) {
                    email_check = " AND " + "email=" + "\"" + val.getEmail() + "\"";
                }
                if (!ObjectUtils.isEmpty(val.getPhone())) {
                    phone_check = " AND " + "phone=" + "\"" + val.getPhone() + "\"";
                } else {

                }

                query_add = ID_check + first_name_check + last_name_check + email_check + phone_check;

                String query_For_Global_Search = apiConstants.getUserDataSql + " where " + query_add + ";";

                System.out.println(query_For_Global_Search);
                this.juxtaposeUsersList = namedParameterJdbcTemplate.
                        query(query_For_Global_Search,
                                (rs, rowNum) -> repositoryUtil.buildJuxtaposeUser(rs, rowNum));

                return true;
            }).orElse(null);

            return Optional.of(juxtaposeUsersList);
        }

        private void resetAllVAlues() {
            this.ID_check = "";
            this.first_name_check = "";
            this.last_name_check = "";
            this.email_check = "";
            this.phone_check = "";
        }

    }
