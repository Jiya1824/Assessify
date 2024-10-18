// src/components/Students.js

import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Students = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Fetch data when the component loads
    axios.get('/api/students')
      .then(response => {
        setStudents(response.data); // Save data to state
      })
      .catch(error => {
        console.error('There was an error fetching students!', error);
      });
  }, []);

  return (
    <div>
      <h1>Students List</h1>
      <ul>
        {students.map((student, index) => (
          <li key={index}>{student.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Students;
