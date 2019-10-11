<!doctype html>
<html lang="en" class="full-height" xmlns="http://www.w3.org/1999/html">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/edit.css">

    <title>Library</title>
</head>
<body style="background-color: #f2ddc6">
<div>
    <nav class="navbar navbar-expand-md navbar-light sticky-top">
        <div class="brand">
            <a class="navbar-brand" type="brand" href="/"><strong>Your Library</strong></a>
        </div>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/books">Books</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/authors">Authors</a>
                </li>
            </ul>
        </div>
        <form class="form-inline my-2 my-lg-0">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <div class="nav-item btn-home">
                    <a href='/' class="btn btn-outline-light my-2 my-sm-0" type="back">Back</a>
                </div>
            </div>
        </form>
    </nav>
</div>

<div class="container">
    <br><br>
    <form method="post" action="/books/add">
        <div class="row" style="margin-bottom: 15px ">
            <div class="col-2 text-left" style="
  padding: 15px;">
                <h4>Title</h4>
            </div>
            <input class="col-10 themed-grid-col" name="title" id="title" placeholder="title">
        </div>
        <div class="row" style="margin-bottom: 30px ">
            <div class="col-2 text-left" style="
  padding: 15px;">
                <h4>Description</h4>
            </div>
            <input class="col-10 themed-grid-col" name="description" id="description" placeholder="description">
        </div>
        <div class="row" style="margin-bottom: 15px ">
            <div class="col-2 text-left" style="
  padding: 15px;">
                <h4>Author's name</h4>
            </div>
            <input class="col-10 themed-grid-col" name="authorName" id="authorName" placeholder="Author's name">
        </div>
        <div class="row" style="margin-bottom: 30px ">
            <div class="col-2 text-left" style="
  padding: 15px;">
                <h4>Url Image</h4>
            </div>
            <input type="text" class="col-10 themed-grid-col" name="urlImg" id="urlImg" placeholder="UrlImg">
        </div>
        <div class="text-center">
            <input type="submit" class="btn btn-outline-success"
                   style="color: #000000;width: 200px; border-radius: 20px " value="Add book"/>
        </div>
    </form>
</div>


</body>
</html>