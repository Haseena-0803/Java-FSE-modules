// Original events array
const events = [
  { name: "Jazz Night", category: "Music", seats: 10 },
  { name: "Baking Workshop", category: "Cooking", seats: 5 },
  { name: "Yoga Class", category: "Health", seats: 8 },
  { name: "Rock Concert", category: "Music", seats: 15 },
];

// Function with default parameter, destructuring, and let/const
const filterEvents = (eventList = [], category = "") => {
  // Clone eventList using spread operator to avoid mutation
  const eventsCopy = [...eventList];
  
  if (!category) return eventsCopy;

  return eventsCopy.filter(({ category: cat }) => cat === category);
};

// Function to render event names
const renderEvents = (eventArray) => {
  const eventListEl = document.getElementById('eventList');
  eventListEl.innerHTML = '';

  eventArray.forEach(({ name }) => {
    const li = document.createElement('li');
    li.textContent = name;
    eventListEl.appendChild(li);
  });
};

// Initial render all events
renderEvents(events);

// Button event listener
document.getElementById('showMusicBtn').addEventListener('click', () => {
  const musicEvents = filterEvents(events, 'Music');
  renderEvents(musicEvents);
});
