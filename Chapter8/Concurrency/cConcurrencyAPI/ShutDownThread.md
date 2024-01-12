
- **shutdown()** does not actually stop any tasks that have already been submitted to the thread executor
- **shutdownNow()** which attempts to stop all running tasks and discards any that have not been started yet