// Sample events data
const events = [
  { id: 1, name: "Book Fair", seats: 5, registered: 0 },
  { id: 2, name: "Tech Meetup", seats: 10, registered: 0 },
  { id: 3, name: "Cooking Class", seats: 3, registered: 0 },
];

// Select container with querySelector
const container = document.querySelector('#eventsContainer');

// Function to render events
function renderEvents() {
  container.innerHTML = ''; // Clear previous content

  events.forEach(event => {
    // Create card div
    const card = document.createElement('div');
    card.style.border = "1px solid #ccc";
    card.style.margin = "10px";
    card.style.padding = "10px";
    card.style.width = "250px";

    // Event name
    const name = document.createElement('h3');
    name.textContent = event.name;
    card.appendChild(name);

    // Seats info
    const seatsInfo = document.createElement('p');
    seatsInfo.textContent = `Seats: ${event.seats} | Registered: ${event.registered}`;
    card.appendChild(seatsInfo);

    // Register button
    const registerBtn = document.createElement('button');
    registerBtn.textContent = "Register";
    registerBtn.disabled = event.registered >= event.seats;
    card.appendChild(registerBtn);

    // Cancel button
    const cancelBtn = document.createElement('button');
    cancelBtn.textContent = "Cancel";
    cancelBtn.disabled = event.registered === 0;
    cancelBtn.style.marginLeft = "10px";
    card.appendChild(cancelBtn);

    // Register event listener
    registerBtn.addEventListener('click', () => {
      if (event.registered < event.seats) {
        event.registered++;
        renderEvents();
      }
    });

    // Cancel event listener
    cancelBtn.addEventListener('click', () => {
      if (event.registered > 0) {
        event.registered--;
        renderEvents();
      }
    });

    container.appendChild(card);
  });
}

// Initial render
renderEvents();
