# GraphQL with spring-boot-starter-graphql

# QueryMapping Example

Watch this space for more updated on GraphQL

Upcoming repos...

 1. MutationMapping 
 2. SchemaMapping


Sample Query:

query {
    allBooks{
        bookId
        bookName
        price
    }
}

mutation {
  createBook(bookName: "Test", author: "Test", price: 200.0) {
    bookId
    bookName
    author
    price
  }
}

---------------------------------------

Bugs faced:

The only way to fix this right now is to annotate the argument correctly with @Argument but new users of this framework might not know this.

java.lang.NullPointerException: null
	at org.springframework.graphql.data.method.annotation.support.SourceMethodArgumentResolver.resolveArgument(SourceMethodArgumentResolver.java:71) ~[spring-graphql-1.0.0.jar:1.0.0]
	at org.springframework.graphql.data.method.HandlerMethodArgumentResolverComposite.resolveArgumen