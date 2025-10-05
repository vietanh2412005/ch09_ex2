package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

import data.ProductIO;
import model.Product;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Lấy đường dẫn thực của file products.txt
        String path = getServletContext().getRealPath("/WEB-INF/products.txt");

        // Đọc danh sách sản phẩm từ file
        ArrayList<Product> products = ProductIO.getProducts(path);

        // Lưu danh sách sản phẩm vào session
        session.setAttribute("products", products);

        // Forward đến trang index.jsp để hiển thị
        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
