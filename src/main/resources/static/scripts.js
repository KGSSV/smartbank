const loginForm = document.getElementById('loginForm');
const errorMessage = document.getElementById('errorMessage');

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const username = event.target.username.value;
    const password = event.target.password.value;

    // Perform validation if needed
    // ...

    // Send the POST request to the /authenticate endpoint
    fetch('/api/users/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Invalid credentials');
        }
        return response.json();
    })
    .then(data => {
        // Handle the successful response (e.g., store the token and redirect)
        // ...
      if (data.token) {
                         // Save the token in localStorage (or any secure storage) for further requests
                         localStorage.setItem('jwtToken', data.token);
                         // Redirect to the new page (transactions.html in this case)
                         window.location.href = 'transactions.html';
                     }
    })
    .catch(error => {
        errorMessage.innerText = error.message;
    });
});
