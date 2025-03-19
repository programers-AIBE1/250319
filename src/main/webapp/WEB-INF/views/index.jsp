<%--
  Created by IntelliJ IDEA.
  User: marsh825
  Date: 25. 3. 19.
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>User</h1>
    <p>
        <%=request.getAttribute("users")%>
    </p>
    <form method="post" action="user">
        <input type="hidden" name="user_id" value="">
        <label>
            Name
            <input name="name" required>
        </label>
        <label>
            E-mail
            <input name="email" type="email" required>
        </label>
        <label>
            Phone
            <input name="phone" required>
        </label>
        <button>
            Submit
        </button>
    </form>
    <h1>Concert</h1>
    <p>
        <%= request.getAttribute("concerts") %>
    </p>
    <form method="post" action="<%= request.getContextPath() %>/concert">
        <input type="hidden" name="concert_id" value="">
        <label>
            Title
            <input name="title" required>
        </label>
        <label>
            Date
            <input name="date" required>
        </label>
        <label>
            Location
            <input name="location" required>
        </label>
        <button>Submit</button>
    </form>
    <h1>Ticket</h1>
    <p>
        <%= request.getAttribute("tickets") %>
    </p>
    <form method="post" action="<%= request.getContextPath() %>/ticket">
        <input type="hidden" name="ticket_id" value="">
        <label>
            Seat
            <input name="seat_number" required>
        </label>
        <label>
            Price
            <input name="price" type="number" required>
        </label>
        <label>
            Date
            <input name="purchase_date" required>
        </label>
        <label>
            concertID
            <input name="concert_id" required>
        </label>
        <label>
            userID
            <input name="user_id" required>
        </label>
        <button>Submit</button>
    </form>
</body>
</html>
