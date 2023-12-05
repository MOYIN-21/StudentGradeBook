document.addEventListener('DOMContentLoaded', function () {
    const viewGradeForm = document.getElementById('viewGradeForm');

    
    fetch('/student/getGrades')
        .then(response => response.json())
        .then(data => {
            if (data.success) {

                data.grades.forEach((grade, index) => {
                    document.querySelector(`input[name="subject${index + 1}"]`).value = grade.subject;
                    document.querySelector(`input[name="score${index + 1}"]`).value = grade.score;
                    document.querySelector(`input[name="grade${index + 1}"]`).value = grade.grade;
                });
            } else {
                alert('Failed to fetch grades. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error fetching grades:', error);
            alert('An error occurred while fetching grades. Please try again.');
        });
});
