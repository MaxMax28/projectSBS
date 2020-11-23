$(document).ready(function () {
    getUser();
});

function getUser() {
    fetch('#userTableForm')
        .then(response => {
            function getUserInfo(resp) {
                let userInfo = '';

                userInfo += '<tr>';
                userInfo += '<td>' + resp.id + '</td>';
                userInfo += '<td>' + resp.name + '</td>';
                userInfo += '<td>' + resp.role + '</td>';
                userInfo += '<tr>';

                return userInfo;
            }
            return getUserInfo(response);
        })
}
























// function userInfo() {
//
//     fetch('/user')
//         .then(response => {
//
//             function getUserInfo (resp) {
//                 let userInfo = document.querySelector('#userTableForm')
//                 let user = new Object(resp);
//                 let userData = '';
//
//                 userData += '<tr>';
//                 userData += '<td>' + user.id + '</td>';
//                 userData += '<td>' + user.name + '</td>';
//                 userData += '<td>' + user.role + '</td>';
//                 userData += '</tr>';
//
//                 userInfo.innerHTML = userData
//
//                 console.log(userInfo)
//
//                 // let data = {
//                 //     firstName: firstName,
//                 //     lastName: lastName,
//                 //     email: email,
//                 //     password: password,
//                 //     roles: [{
//                 //         id: roleId
//                 //     }
//                 //     ]
//                 // };
//
//                 return userInfo;
//             }
//             return getUserInfo(response);
//         })
//
// }


