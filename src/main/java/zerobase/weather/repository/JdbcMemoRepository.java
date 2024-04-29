package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.damain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    /**
     * application.properties에 있는 정보들이 dataSource에 담긴다.
     * 이를 활용해 JdbcTemplate을 만든다.
     * autowired로 application.properties에 있는 정보를 가져옴
     */
    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll() {
        String sql = "select * from memo";
        return jdbcTemplate.query(sql, memoRowMapper());
    }

    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id=?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
    }

    /**
     * jdbc를 통해 db에서 가져온 데이터는 ResultSet 형식의 데이터이다.
     * 때문에 스프링에서 바로 사용하지 못한다.
     * 이 데이터를 사용하려면 domain에 만든 memo 형식으로 바꿔줘야한다.
     * 그래서 ResultSet을 Memo로 매핑해주는 RowMapper 메서드를 구현해서 사용했다.
     */
    private RowMapper<Memo> memoRowMapper() {
        // ResultSet
        // {id = 1, text = 'asdasdasdasd'}
        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );
    }
}
