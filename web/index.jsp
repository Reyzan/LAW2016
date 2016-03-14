<%-- 
    Document   : index
    Created on : Mar 14, 2016, 4:57:53 PM
    Author     : Ari
--%>

<%@page import="address_book.User"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Utama</title>
        <!-- Bootstrap core CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
        <!-- MDB core CSS -->
        <link href="http://mdbootstrap.com/mdbcdn/mdb.min.css" rel="stylesheet">   

        <!-- JQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="http://mdbootstrap.com/mdbcdn/mdb.min.js"></script>
        <!-- Material Design Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"  rel="stylesheet" >
    </head>
    <body>
        <div class="container">
            <div class="header clearfix">
                <nav>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="index.jsp" class="btn waves-effect waves-light indigo btn-primary blue"><i class="material-icons">home</i></a></li>
                        <li role="presentation"><a href="#add" class="btn waves-effect waves-light indigo btn-success green" data-toggle="modal"><i class="material-icons">add</i></a>  </li>
                    </ul>
                </nav>
                <h3 class="text-muted">Tutorial 2</h3>
            </div>
            <div class="jumbotron">
                <h3 class="text-center">My Address Book - Fauzan Azhari - 1306381811</h3>
                <%
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Quiz2PU");
                    EntityManager em = emf.createEntityManager();
                    EntityTransaction tx = em.getTransaction();
                    Query q = em.createNamedQuery("User.findAll");
                    Collection<User> theUser = q.getResultList();
                    em.close();
                    out.print("<table class='table'>");
                    out.print("<tr>");
                    out.print("<td>");
                    out.print("Nama");
                    out.print("</td>");
                    out.print("<td>");
                    out.print("Telepon");
                    out.print("</td>");
                    out.print("<td>");
                    out.print("Email");
                    out.print("</td>");
                    out.print("</tr>");
                    
                    for (User a : theUser) {
                        out.print("<tr>");
                        out.print("<td>");
                        out.print(a.getNama());
                        out.print("</td>");
                        out.print("<td>");
                        out.print(a.getTelepon());
                        out.print("</td>");
                        out.print("<td>");
                        out.print(a.getEmail());
                        out.print("</td>");
                        
                        out.print("<td>");
                        out.print("<a href='edit.jsp?id=" + "' class='btn-floating btn-small waves-effect waves-light indigo btn-primary blue'><i class='material-icons'>edit</i></a>");
                        out.print("</td>");
                        out.print("<td>");
                        out.print("<a href='delete?id="+ a.getId() +"' class='btn-floating btn-small waves-effect waves-light indigo btn-danger red'><i class='material-icons'>delete</i></a>");
                        out.print("</td>");
                    }
                %>
            </div>
        </div>
        <!-- Modal -->
        <div id="add" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title text-center">Add Biodata</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <form action="addAuthor" name="form" method="post">
                                Nama : <input class="form-control validate" type="text" name="nama" required aria-required="true">
                                <br>
                                Email : <input class="form-control validate" type="email" name="email" required aria-required="true">
                                <br>
                                Telepon : <input class="form-control validate" type="text" name="telepon" required aria-required="true">
                                <br>
                                Alamat : <input class="form-control validate" type="text" name="alamat" required aria-required="true">
                                <br>
                                Kota : <input class="form-control validate" type="text" name="kota" required aria-required="true">
                                <br>
                                Provinsi : <input class="form-control validate" type="text" name="provinsi" required aria-required="true">
                                <br>
                                Kode Pos : <input class="form-control validate" type="text" name="kode_pos" required aria-required="true">
                                <br>
                                Negara : 
                                <select class="form-control validate" name="negara">
                                    <option value="1">Indonesia</option>
                                    <option value="2">Jerman</option>
                                    <option value="3">Inggris</option>
                                    <option value="4">Arnor</option>
                                </select>
                                <br>
                                Nama Socmed1: <input class="form-control validate" type="text" name="nama_socmed1"  required aria-required="true">
                                <br>
                                Jenis Socmed1:
                                <select class="form-control" name="jenis_socmed1" >
                                    <option value="1">Facebook</option>
                                    <option value="2">Twitter</option>
                                    <option value="3">Path</option>
                                    <option value="4">Instagram</option>
                                </select>

                                <br>
                                Nama Socmed2: <input class="form-control validate" type="text" name="nama_socmed2"  required aria-required="true">
                                <br>
                                Jenis Socmed2: 
                                <select class="form-control" name="jenis_socmed2">
                                    <option value="1">Facebook</option>
                                    <option value="2">Twitter</option>
                                    <option value="3">Path</option>
                                    <option value="4">Instagram</option>
                                </select>
                                <button class="btn btn-default" id="submit" type="submit" name="action"><i class="material-icons right">send</i>Submit</button>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
