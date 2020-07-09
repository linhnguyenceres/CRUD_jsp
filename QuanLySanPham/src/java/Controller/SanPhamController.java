/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SanPhamDao;
import Dto.SanPham;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SanPhamController", urlPatterns = {"/SanPhamController"})
public class SanPhamController extends HttpServlet{
    private final String INSERT_OR_EDIT = "/SanPham.jsp";
    private final String LIST_SANPHAM = "/ListSanPham.jsp";
    private final SanPhamDao dao;
    
    public SanPhamController() throws SQLException, ClassNotFoundException{
        super();
        dao = new SanPhamDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward = "";
        String action = request.getParameter("action");
        
        if(action.equalsIgnoreCase("listSanPham")){
            forward = LIST_SANPHAM;
            List<SanPham> sps = null;
            try {
                sps = dao.getAllSanPham();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("sanphams", sps);
        }else if(action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            SanPham sp = null;
            try {
                sp = dao.getSanPhamByID(id);
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("sanpham", sp);
        } else if(action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                dao.deleteSanPham(id);
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
            forward = LIST_SANPHAM;
            List<SanPham> sps = null;
            try {
                sps = dao.getAllSanPham();
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("sanphams", sps);
        }else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        SanPham sp = new SanPham();
        sp.setTensp(request.getParameter("tensp"));
        sp.setQuycach(request.getParameter("quycach"));
        
        BigDecimal gia = BigDecimal.valueOf(Long.parseLong(request.getParameter("gia")));
        sp.setGia(gia);
        
        sp.setNhasx(request.getParameter("nhasx"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty()){
            try {
                dao.insertSanPham(sp);
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sp.setId(Integer.parseInt(id));
            try {
                dao.updateSanPham(sp);
            } catch (SQLException ex) {
                Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        List<SanPham> sps = null;
        try {
            sps = dao.getAllSanPham();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("sanphams", sps);
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_SANPHAM);
        view.forward(request, response);
        
    }
}
