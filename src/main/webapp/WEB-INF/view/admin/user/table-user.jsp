<%@page contentType="text/html" pageEncoding="UTF-8" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

         <html lang="en">

         <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>User Page</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
               integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
               crossorigin="anonymous" />
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
               integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
               crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <link rel="stylesheet" href="/css/demo.css" />
         </head>

         <body>
            <div class="container mt-5 mb-3">
               <div class="row">
                  <div class="col-md-12 col-12 mx-auto">
                     <div class="d-flex justify-content-between mb-2">
                        <h3>Table users</h3>
                        <a class="btn btn-primary" href="/admin/user/create">Create a user</a>
                     </div>
                     <hr />
                     <table class="table table-bordered table-hover">
                        <thead>
                           <tr>
                              <th scope="col">ID</th>
                              <th scope="col">Email</th>
                              <th scope="col">Full name</th>
                              <th scope="col">Action</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach var="user" items="${users}">
                              <tr>
                                 <th scope="row">${user.id}</th>
                                 <td>${user.email}</td>
                                 <td>${user.fullName}</td>
                                 <td>
                                    <a href="/admin/user/${user.id}" class="btn btn-success">View</a>
                                    <a href="/admin/user/update/${user.id}"
                                       class="text-white btn btn-warning mx-2">Update</a>
                                    <a href="/admin/user/delete/${user.id}" class="btn btn-danger">Delete</a>
                                    <a href="/admin/user/assignrole/${user.id}" class="btn btn-primary mx-2">Assign
                                       Role</a>
                                    <a href="/admin/user/assigncompany/${user.id}" class="btn btn-primary mx-2">Assign
                                       Company</a>
                                 </td>
                              </tr>
                           </c:forEach>
                        </tbody>
                     </table>
                  </div>
               </div>
            </div>
         </body>

         </html>