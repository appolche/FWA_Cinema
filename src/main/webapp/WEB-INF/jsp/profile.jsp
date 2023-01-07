<%@ page import="edu.school21.cinema.models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
<%--    <style>--%>
<%--        table, th, td {--%>
<%--            border: 1px solid black;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>

<table width="500" align="center">
    <tr>
        <td rowspan="2" >
            <main>
                <input type="file" name="image" id="image" accept="image/*" />
                <div id="preview">
                    <div id="avatar"></div>
                    <button
                            id="upload-button"
                            aria-labelledby="image"
                            aria-describedby="image"
                    >
                        Upload
                    </button>
                </div>
            </main>

            <style>
                body {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                }

                #avatar {
                    background-color: grey;
                    height: 300px;
                    width: 220px;
                    border: 1px solid black;
                    transition: background ease-out 200ms;
                }

                #preview {
                    position: relative;
                }

                input[type="file"] {
                    display: none;
                }

                button {
                    padding: 18px;
                    border: none;
                    cursor: pointer;
                    background-color: #08f;
                    transition: background-color ease-out 120ms;
                    position: absolute;
                    right: 30%;
                    top: 105%;
                }

                button:hover {
                    background-color: #45a;
                }
            </style>

            <script>
                const UPLOAD_BUTTON = document.getElementById("upload-button");
                const FILE_INPUT = document.querySelector("input[type=file]");
                const AVATAR = document.getElementById("avatar");

                UPLOAD_BUTTON.addEventListener("click", () => FILE_INPUT.click());

                FILE_INPUT.addEventListener("change", event => {
                    const file = event.target.files[0];

                    const reader = new FileReader();
                    reader.readAsDataURL(file);

                    reader.onloadend = () => {
                        AVATAR.setAttribute("aria-label", file.name);
                        AVATAR.style.background = `url(${reader.result}) center center/cover`;
                    };
                });
            </script>
        </td>
        <td valign="top">
            <p align="left"><strong>
                <%=((User)session.getAttribute("User")).getFirstName()%>
                <%=((User)session.getAttribute("User")).getLastName()%>
            </strong></p>
            <p align="left"><strong>
                <%=((User)session.getAttribute("User")).getEmail()%>
            </strong></p>
        </td>
    </tr>
    <tr>
        <td valign="bottom">
            <table width="500"  align="center" border="1px solid black" text-align="center">
                <tr>
                    <th>Date</th>
                    <th>Time</th>
                    <th>IP</th>
                </tr>
                <tr>
                    <td>December 10, 2020</td>
                    <td>05:00</td>
                    <td>127.0.0.1</td>
                </tr>
                <tr>
                    <td>December 09, 2020</td>
                    <td>04:00</td>
                    <td>127.0.0.1</td>
                </tr>
                <tr>
                    <td>December 08, 2020</td>
                    <td>03:00</td>
                    <td>127.0.0.1</td>
                </tr>
            </table>
        </td>
    </tr>
<%--    <tr>--%>
<%--        <td valign="bottom">--%>
<%--            <table width="500"  align="left" border="1px solid black" text-align="center">--%>
<%--                <tr>--%>
<%--                    <th>File name</th>--%>
<%--                    <th>Size</th>--%>
<%--                    <th>MIME</th>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>December 10, 2020</td>--%>
<%--                    <td>05:00</td>--%>
<%--                    <td>127.0.0.1</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>December 09, 2020</td>--%>
<%--                    <td>04:00</td>--%>
<%--                    <td>127.0.0.1</td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>December 08, 2020</td>--%>
<%--                    <td>03:00</td>--%>
<%--                    <td>127.0.0.1</td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </td>--%>
<%--    </tr>--%>
</table>

</body>
</html>