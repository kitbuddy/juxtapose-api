package com.juxtapose.juxtaposeapi.Repository;

import com.juxtapose.juxtaposeapi.CommonConstants.ApiConstants;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.repositoryAPI.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class userRepository implements IUserRepository {

   private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   private final RepositoryUtil repositoryUtil;
   ApiConstants apiConstants;

    public userRepository(JdbcTemplate jdbcTemplate,
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
}
