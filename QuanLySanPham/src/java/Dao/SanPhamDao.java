/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DataConnection.ConnectionManagement;
import Dto.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SanPhamDao {
    private final Connection conn;
    
    public SanPhamDao() throws SQLException, ClassNotFoundException{
        conn = ConnectionManagement.getConnection();
    }
    
    public void insertSanPham(SanPham sp) throws SQLException{
        String SQL = "INSERT into SanPham (tensp, quycach, gia, nhasx) VALUES (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, sp.getTensp());
        ps.setString(2, sp.getQuycach());
        ps.setBigDecimal(3, sp.getGia());
        ps.setString(4, sp.getNhasx());
        ps.executeUpdate();
    }
    
    public void updateSanPham(SanPham sp) throws SQLException{
        String SQL = "UPDATE SanPham  SET tensp = ?, quycach= ?, gia = ?, nhasx= ? WHERE id = ?";
        PreparedStatement ps = conn.prepareCall(SQL);
        ps.setString(1, sp.getTensp());
        ps.setString(2, sp.getQuycach());
        ps.setBigDecimal(3, sp.getGia());
        ps.setString(4, sp.getNhasx());
        ps.setInt(5, sp.getId());
        ps.executeUpdate();
    }
    
    public void deleteSanPham(int id) throws SQLException{
        String SQL = "DELETE from SanPham WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
    public List<SanPham> getAllSanPham() throws SQLException{
        List<SanPham> sps = new ArrayList<SanPham>();
        
        String SQL = "SELECT * from SanPham";
        Statement s = conn.createStatement();
        
        ResultSet rs = s.executeQuery(SQL);
        while(rs.next()){
            SanPham sp = new SanPham();
            sp.setId(rs.getInt("id"));
            sp.setTensp(rs.getString("tensp"));
            sp.setQuycach(rs.getString("quycach"));
            sp.setGia(rs.getBigDecimal("gia"));
            sp.setNhasx(rs.getString("nhasx"));
            sps.add(sp);
        }
        return sps;
    }
    
    public SanPham getSanPhamByID(int id) throws SQLException{
        SanPham sp = new SanPham();
        
        String SQL = "SELECT * FROM SanPham WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1,id);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            sp.setId(rs.getInt("id"));
            sp.setTensp(rs.getString("tensp"));
            sp.setQuycach(rs.getString("quycach"));
            sp.setGia(rs.getBigDecimal("gia"));
            sp.setNhasx(rs.getString("nhasx"));
        }
        return sp;
    }
}
