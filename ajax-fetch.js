const form = document.getElementById('registrationForm');
const messageDiv = document.getElementById('message');

// Mock API URL (no real server, so just for demonstration)
const mockApiUrl = 'https://jsonplaceholder.typicode.com/posts';

form.addEventListener('submit', (e) => {
  e.preventDefault();
  messageDiv.textContent = 'Sending registration...';

  const formData = {
    name: form.elements['name'].value.trim(),
    email: form.elements['email'].value.trim(),
    event: form.elements['event'].value,
  };

  // Simulate network delay with setTimeout inside fetch
  setTimeout(() => {
    fetch(mockApiUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formData),
    })
      .then(response => {
        if (!response.ok) throw new Error('Failed to submit');
        return response.json();
      })
      .then(data => {
        messageDiv.textContent = `Registration successful! ID: ${data.id}`;
        form.reset();
      })
      .catch(error => {
        messageDiv.textContent = 'Error: ' + error.message;
      });
  }, 1500); // 1.5 seconds delay
});
