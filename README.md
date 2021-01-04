# hibernate-mapping-tutorial

We can map collection elements of Persistent class in Hibernate. You need to declare the type of collection in Persistent class from one of the following types:

 - java.util.List
 - java.util.Set
 - java.util.SortedSet
 - java.util.Map
 - java.util.SortedMap
 - java.util.Collection
 - or write the implementation of 		   org.hibernate.usertype.UserCollectionType

The persistent class should be defined like this for collection element.

        package com.package;
            
        import java.util.List;
            
        public  class Question {
        	private  int id;
            private String qname;
            private List<String> answers;//List can be of any type
            
          //getters and setters
    }
<hr>

## Mapping collection in mapping file

There are many subelements of  **`<class>`**  elements to map the collection. They are  **`<list>`**,  **`<bag>`**,  **`<set>`**  and  **`<map>`**.
<hr>

## Indexed Collection

The collection elements can be categorized in two forms:

-   **indexed**  ,and
-   **non-indexed**

The List and Map collection are indexed whereas set and bag collections are non-indexed. Here, indexed collection means List and Map requires an additional element  **<index>**.
<hr>

## Collection Elements

The collection elements can have value or entity reference (another class object). We can use one of the 4 elements

-   **element**
-   **component-element**
-   **one-to-many**, or
-   **many-to-many**

The element and component-element are used for normal value such as string, int etc. whereas one-to-many and many-to-many are used to map entity reference.
