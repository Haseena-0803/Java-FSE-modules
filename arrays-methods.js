// Initial array of events
const events = [
  { name: "Baking Workshop", category: "Cooking" },
  { name: "Jazz Night", category: "Music" },
  { name: "Rock Concert", category: "Music" },
  { name: "Yoga Class", category: "Health" }
];

// Add new events using .push()
events.push({ name: "Classical Music Evening", category: "Music" });

// Function to display events as list items
function displayEvents(eventArray) {
  const eventCards = document.getElementById('eventCards');
  eventCards.innerHTML = '';

  // Use .map() to create formatted display strings
  eventArray.map(event => {
    const li = document.createElement('li');
    li.textContent = `Workshop on ${event.name}`;
    eventCards.appendChild(li);
  });
}

// Show all events initially
displayEvents(events);

// Filter music events and show on button click
document.getElementById('showMusic').addEventListener('click', () => {
  const musicEvents = events.filter(event => event.category.toLowerCase() === 'music');
  displayEvents(musicEvents);
});
