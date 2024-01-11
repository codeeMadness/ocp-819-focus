<h3>Guarding Sensitive Data from Output</h3>

Sensitive contexts include the following:

- Writing to a log file
- Printing an exception or stack trace
- System.out and System.err messages
- Writing to data files

<h3>Protecting Data in Memory</h3>

- <b>char[]</b> not stored as a String, so Java won't place it in the String pool, where it could exist in memory

- it is good practice to set confidential data to null when you're done using it

```java
Console console = System.console();
char[] password = console.readPassword();
Arrays.fill(password, 'x');

LocalDate dateOfBirth = getDateOfBirth();
// use date of birth
dateOfBirth = null;
```

<h3>Limiting File Access</h3>

- principle of least privilege

```properties
grant {
    permission java.io.FilePermission
    "C:\\water\\fish.txt",
    "read";
};
```
