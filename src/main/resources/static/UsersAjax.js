function saveUser() {
    var jsonVar = {
        username: $("#username").val(),
        lastname: $("#lastname").val(),
        age: $("#age").val(),
        email: $("#email").val(),
        password: $("#password").val(),
        rolesList: $("#rolesList").val()
    };

    $.ajax({
        url: "/admin/add",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(jsonVar),
        async: false,
        type: 'POST'
    });
    getDataUsers();
}

function getDataUsers() {
    $.ajax({
        type: 'GET',
        url: '/admin/users',
        success: function (response) {
            var tr;
            $('#usersBody').html('');
            $.each(response, function (index, userEntity) {
                tr = $('<tr/>');
                tr.append("<td>" + userEntity.id + "</td>");
                tr.append("<td>" + userEntity.username + "</td>");
                tr.append("<td>" + userEntity.lastname + "</td>");
                tr.append("<td>" + userEntity.age + "</td>");
                tr.append("<td>" + userEntity.email + "</td>");
                tr.append("<td>" + userEntity.rolesList + "</td>");
                tr.append("<td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#editModal' onclick='editUser($(this))' value='" + userEntity.id + "'>Edit</button></td>");
                tr.append("<td><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteModal' onclick='deleteUser($(this))' value='" + userEntity.id + "'>Delete</button></td>");
                $('#usersBody').append(tr);
            });
        }
    });
}

$(document).ready(getDataUsers);

//update user
function editUser(row) {
    var userId = row.attr('value');
    $.ajax({
        url: "/admin/editUser",
        dataType: 'json',
        contentType: 'application/json',
        data: userId,
        type: 'POST',
        success: function (data) {
                $('#idEdit').val(data.id);
                $('#usernameEdit').val(data.username);
                $('#lastnameEdit').val(data.lastname);
                $('#ageEdit').val(data.age);
                $('#emailEdit').val(data.email);
                $('#passwordEdit').val("");
        },
        error: function (xhr, status, errorThrown) {
            alert('edit user failed with status: ' + status + ". "
                + errorThrown);
        }
    })
}

//update post
function updateUser() {
    var jsonVar = {
        id: $("#idEdit").val(),
        username: $("#usernameEdit").val(),
        lastname: $("#lastnameEdit").val(),
        age: $("#ageEdit").val(),
        email: $("#emailEdit").val(),
        password: $("#passwordEdit").val(),
        rolesList: $("#roleEdit").val()
    };

    $.ajax({
        url: "/admin/edit",
        dataType: 'json',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(jsonVar),
        type: 'POST',
    });
    getDataUsers()
}

//delete user
function deleteUser(row) {
    var userId = row.attr('value');
    $.ajax({
        url: "/admin/editUser",
        dataType: 'json',
        contentType: 'application/json',
        data: userId,
        type: 'POST',
        success: function (data) {
            $('#idDelete').val(data.id);
            $('#usernameDelete').val(data.username);
            $('#lastnameDelete').val(data.lastname);
            $('#ageDelete').val(data.age);
            $('#emailDelete').val(data.email);
        }
    })
}

//Delete post
function removeUser() {
    var id = $("#idDelete").val();
    $.ajax({
        url: "/admin/delete",
        dataType: 'json',
        contentType: 'application/json',
        data: id,
        async: false,
        type: 'POST',
    });
    getDataUsers()
}