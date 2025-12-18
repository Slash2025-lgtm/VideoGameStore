### VideoGameStore

# Phase 1
## Step 1: Category Controller Methods
During Step 1, I initiated the debugging process. The task was relatively straightforward, primarily involving identifying issues within the application and implementing necessary annotations and configurations to establish connectivity with Insomnia and the SQL database. To facilitate the connection, I inserted the relevant data into the database. The class and methods were already made, though none of the methods had been implemented.

The needed annotations were happening in the controller, such as "Get, Post, Put, and Delete" along with other annotations like RequestMapping, Cross-Origin, and RestController.

@Autowired: Allows Spring automatically inject dependencies into classes.
@Component: Tell Spring to both recognize and manage the class for dependency injection.


@GetMapping (Get) - Gets a row of data from the database
@PostMapping (Post) - Creates rows in the database
@PutMapping (Put) - Updates the database
@DeleteMapping (Delete) - Deletes the database

@CrossMapping - Allows requests from the "localhost:8080".
@RestController - Makes the class compatible with the "Get, Post, Delete, and Map".
@RequestMapping - This makes it so you know the location of your database in the localhost:8080 website

## Step 2: Authorization
This Step was also straightforward; all I had to do was allow the account with admin to see/use the admin sections, while users without admin could not. Going into fixing this, all I had to do was implement the @PreAuthorize anotation which basically checks if one of the rest control annotations could be accessed by only an admin or every user.

@PreAuthorize("permitAll") - Allows all users to access
@PreAuthorize("hasRole('ROLE_ADMIN')") - Checks if the user's role is admin, then allows access if the user is an admin

# Phase 2
## Bug 1
Phase 2 bug 1 was different, where I didn't really have to do much since most of it was already done. The only thing I had to do was add the proper annotations to the products and fix where the create was updating. I also had to @Autowired and create the constructor

## Bug 2
Phase 2 bug 2 was just going into the database on MySQL Workbench and commenting out the duplicates I found there.

# Phase 3
Phase 3 Feature 3 I didn't finish or get working, so I'll just go over what I was able to complete. I was able to get it print the list it was making to Insamnia, though I was not able to get the products and stuff working on there
