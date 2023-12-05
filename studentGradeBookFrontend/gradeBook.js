document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');
    const loginError = document.getElementById('login-error');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const userType = document.querySelector('input[name="userType"]:checked').value;

        if (userType === 'teacher') {
            fetch('/teacher/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        window.location.href = '/teacher/dashboard';
                    } else {
                        loginError.textContent = 'Login failed. Check your credentials.';
                    }
                })
                .catch(error => {
                    console.error('Error during login:', error);
                    loginError.textContent = 'An error occurred during login. Please try again.';
                });
        } else if (userType === 'student') {
            fetch('/student/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        window.location.href = '/student/dashboard';
                    } else {
                        loginError.textContent = 'Login failed. Check your credentials.';
                    }
                })
                .catch(error => {
                    console.error('Error during login:', error);
                    loginError.textContent = 'An error occurred during login. Please try again.';
                });
        }
    });

    const registerButton = document.getElementById('registerButton');
    registerButton.addEventListener('click', function (event) {

        console.log('Registration logic goes here');
    });
});
