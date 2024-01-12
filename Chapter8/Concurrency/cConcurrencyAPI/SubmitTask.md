<h3>Submit vs Execute</h3>

<table>
    <tr>
        <td>void execute(Runnable command)</td>
        <td>Future submit(Runnable task)</td>
    </tr>
    <tr>
        <td></td>
        <td>Future submit(Callable task)</td>
    </tr>
</table>

- recommend **submit() over execute()** whenever possible.