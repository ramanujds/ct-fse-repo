package com.ct.springboot.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ct.springboot.jdbc.model.Trainee;
@Repository
public class TraineRepoImpl implements TraineeRepo {
	
	@Autowired
	JdbcTemplate jdbcTempplate;
	
	class TraineeRowMapper implements RowMapper<Trainee>{
		@Override
		public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Trainee trainee=new Trainee(rs.getInt("traineeId"),rs.getString("traineeName"),rs.getString("email"),
					LocalDate.of(rs.getDate("dob").getYear(), rs.getDate("dob").getMonth()+1, rs.getDate("dob").getDate())
					);
			return trainee;
			
		}
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		System.out.println(trainee);
		int updated=jdbcTempplate.update("insert into trainee values(?,?,?,?)",new Object[] {
				trainee.getTraineeId(),trainee.getTraineeName(),trainee.getEmail(),trainee.getDob()
		});
		
		return updated!=0?trainee:null;
	}

	@Override
	public Optional<Trainee> getTraineeById(int traineeId) {
		// TODO Auto-generated method stub
//		Optional.of(jdbcTempplate.queryForObject("select * from trainee where traineeId=?",ne Object[] {
//			traineeId
//		},Trainee.class));
		
		return Optional.of(jdbcTempplate.queryForObject("select * from trainee where traineeId=?",new Object[] {
			traineeId
		},new BeanPropertyRowMapper<Trainee>(Trainee.class)));
	}

	@Override
	public boolean deleteTraineeById(int traineeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		// TODO Auto-generated method stub
		return null;
	}

}
