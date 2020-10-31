package com.mcw.mycarwash.DaoImpl;

import com.mcw.mycarwash.Dao.DocumentCodeDao;
import com.mcw.mycarwash.Model.DocumentCode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class DocumentCodeDaoImpl implements DocumentCodeDao {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate jdbcTemplateName;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplateName = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public String addDocCode(DocumentCode documentCode) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        session.save(documentCode);
        return "Inserted";
    }

    @Override
    public String editDocCode(DocumentCode documentCode) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        session.update(documentCode);
        return "Updated";
    }

    @Override
    public String updateAutoCode(DocumentCode documentCode) throws Exception {
        return "Updated";
    }

    @Override
    public String nextDocNumber(String clientId, String docCode) throws Exception {
        String Code;
        DocumentCode documentCode = new DocumentCode();
        String query = "SELECT * FROM doccode WHERE doc_id='" + docCode + "' AND client_id='" + clientId + "'";
        List<DocumentCode> codeLIst = jdbcTemplate.query(query, new BeanPropertyRowMapper(DocumentCode.class));
        if (!codeLIst.isEmpty()) {
            for (DocumentCode documentCode1 : codeLIst) {
                documentCode = documentCode1;
            }
            Code = documentCode.getDocId() + documentCode.getAutoCode();
            query = "UPDATE doccode SET auto_code= ? WHERE doc_id=? AND client_id=?";
            int responce = jdbcTemplate.update(query, documentCode.getAutoCode() + 1, docCode, clientId);
        } else {
            query = "INSERT INTO doccode (doc_id,client_id,auto_code) VALUES (?,?,?)";
            int responce = jdbcTemplate.update(query, docCode, clientId, 1001);
            Code = docCode + 1000;
        }
        return Code;
    }
}
