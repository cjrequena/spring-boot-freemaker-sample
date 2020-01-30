<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Hello ${name}</title>
        <#include "/common/load-css.ftl">
    </head>

    <body>

        <div class="container">
        <#include "/common/header.ftl">
        <h2 class="hello-title">Hello ${name}!</h2>
        <#include "/common/footer.ftl">
        </div>

        <#include "/common/load-js.ftl">
    </body>
</html>
