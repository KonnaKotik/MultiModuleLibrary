<!doctype html>
<html lang="en" class="full-height">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/books.css">

    <script>
        function sendId(bookId
        ) {
            $.ajax({
                type: 'post',
                url: '/books' + bookId + '/deletById',
                data: {
                    bookId: bookId
                }
            }).done(function (data) {
                location.reload();
            })
        }
    </script>

    <title>Library</title>
</head>
<body style="background-color: #f2ddc6">
<div>
    <nav class="navbar navbar-expand-md navbar-light sticky-top">
        <div class="brand">
            <a class="navbar-brand" type = "brand" href="/"><strong>Your Library</strong></a>
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
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4"></div>
                <div class="col-4 text-right">
                    <a href="/books/add" class="btn btn-outline-success" style="color: #000000;width: 150px ">Add Book</a>

                </div>
            </div>
            <br><br>
            <#list books as book>
    <div class="row">
        <div class="col-8">

           <div class="row">
               <div class="col-3">
                   <a> <img src = "${book.urlImg}" width="160"/></a>
               </div>
               <div class="col-9">
                   <p>
                     <#-- <a href="/books/${book.id}">-->
                   <h3 > "${book.title}" </h3>
                     <#--  </a>-->
                   </p>
                   <p>
                   <h5>${book.description} </h5>
                   </p>
                   <div style="position:absolute; right: 0px; bottom: 0px;">
                       <a href="/authors/${book.authorId}">
                       <h6 >${book.authorName}</h6>
                       </a>
                   </div>
               </div>
           </div>
          <hr>

        </div>
        <div class="col-4 text-center">
            <a  href="/books/edit/${book.id}"  class="btn btn-outline-success" style="color: #000000;width: 150px ">Edit book</a>
        </div>


    </div>
            </#list>
        </div>

</body>
</html>

    
</body>
</html>