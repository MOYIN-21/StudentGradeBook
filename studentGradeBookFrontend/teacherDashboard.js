document.addEventListener('DOMContentLoaded', function () {
    const gradeForm = document.getElementById('gradeForm');

    gradeForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const subjects = [];
        const scores = [];
        const grades = [];

        for (let i = 1; i <= 10; i++) {
            const studentName = document.getElementById(`studentName${i}`).value;
            const subject = document.getElementById(`subject${i}`).value;
            const score = document.getElementById(`score${i}`).value;
            const grade = document.getElementById(`grade${i}`).value;

            subjects.push(subject);
            scores.push(score);
            grades.push(grade);
        }

        fetch('/teacher/saveGrades', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ subjects, scores, grades }),
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('Grades saved successfully!');
                } else {
                    alert('Failed to save grades. Please try again.');
                }
            })
            .catch(error => {
                console.error('Error saving grades:', error);
                alert('An error occurred while saving grades. Please try again.');
            });
    });
});
