/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ArticleDTO;
import dtos.StatusDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author 84909
 */
public class StatusDAO {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public List<StatusDTO> getStatus() throws Exception {
        List<StatusDTO> list = new ArrayList<>();
        String sql = "Select statusID,statusName From tblStatus";
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new StatusDTO(rs.getInt("statusID"), rs.getString("statusName")));
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
