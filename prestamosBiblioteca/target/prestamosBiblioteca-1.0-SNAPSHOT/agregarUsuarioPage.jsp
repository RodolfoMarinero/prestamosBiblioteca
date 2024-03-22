<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agregar Nuevo Usuario</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Agregar Nuevo Usuario</h1>

    <form method="post" action="agregarUsuario.jsp">
        <div class="form-group">
            <label for="txtNombreAdd">Nombre:</label>
            <input type="text" class="form-control" id="txtNombreAdd" name="txtNombreAdd" required>
        </div>
        <div class="form-group">
            <label for="txtCorreoAdd">Correo:</label>
            <input type="text" class="form-control" id="txtCorreoAdd" name="txtCorreoAdd" required>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
        <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>

<!-- Bootstrap JS (opcional, solo necesario si se requieren componentes de Bootstrap que utilicen JavaScript) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
