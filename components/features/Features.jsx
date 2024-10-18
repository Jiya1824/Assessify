import React, { useEffect, useState } from 'react';
import Personal from '../../Assets/personal1.png';
import Wide from '../../Assets/wide1.png';
import Analysis from '../../Assets/analysis1.png';
import './features.css'
import Cards from './Card'

function Features(prop) {
  return (
    <div className='container-write' id='feature'>
      <div className='feature_head concert-one-regular'>Special Features</div>
        <div className='cards_container'>
        <Cards heading="Personalized Assessments" img={Personal} desc="Tailored assessments based on user preferences, skill level, or learning objectives to provide a customized learning experience.
"/>
        <Cards heading="Wide Range of Assessments" img={Wide} desc="Access to a diverse library of assessments covering various subjects, topics, and skill sets to cater to different user needs and interests.
"/>
        <Cards heading="Detailed Performance Analytics" img={Analysis} desc="Unlock insights! Get scores, strengths, and areas to shine. Tailor your journey with our comprehensive performance analytics."/>
        </div>
        
    </div>
  )
}

export default Features;
