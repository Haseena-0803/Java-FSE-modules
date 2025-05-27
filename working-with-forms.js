const form = document.getElementById('registrationForm');

const nameError = document.getElementById('nameError');
const emailError = document.getElementById('emailError');
const eventError = document.getElementById('eventError');

form.addEventListener('submit', (e) => {
  e.preventDefault();

  // Clear previous errors
  nameError.textContent = '';
  emailError.textContent = '';
  eventError.textContent = '';

  const name = form.elements['name'].value.trim();
  const email = form.elements['email'].value.trim();
  const selectedEvent = form.elements['event'].value;

  let valid = true;

  if (name === '') {
    nameError.textContent = 'Name is required.';
    valid = false;
  }

  if (email === '') {
    emailError.textContent = 'Email is required.';
    valid = false;
  } else if (!/\S+@\S+\.\S+/.test(email)) {
    emailError.textContent = 'Invalid email format.';
    valid = false;
  }

  if (selectedEvent === '') {
    eventError.textContent = 'Please select an event.';
    valid = false;
  }

  if (valid) {
    alert(`Thank you for registering, ${name}, for the event: ${selectedEvent}`);
    form.reset();
  }
});
