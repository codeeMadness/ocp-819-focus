<h3>Starvation</h3>
- Starvation occurs when a single thread is perpetually denied access to a shared resource or lock.
- For example: Every time Foxy stands up to go get food, one of the other foxes sees her and rushes to eat
  before her. Foxy literally and figuratively experiences starvation.

<h3>Livelock</h3>
- Livelock occurs when two or more threads are conceptually blocked forever, although they are each still
  active and trying to complete their task.
- For example: Fox and Tails cannot finish their meals, so they both let go and come to opposite side, Now Foxy has the water, Tails has the
  food, and neither is able to finish their meal!

<h3>Possible Outcomes in Race Condition</h3>

- Both users are able to create accounts with username ZooFan.
- Both users are unable to create an account with username ZooFan, returning an error message to both
users.
- One user is able to create the account with the username ZooFan, while the other user receives an
error message. (_considered the best solution_)