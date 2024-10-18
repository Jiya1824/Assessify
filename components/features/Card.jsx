import React from 'react'
import './card.css'
function Cards(prop) {
  return (
    <div className="feature">
        <h2 className='feature_h2'>{prop.heading}</h2>
        <img src={prop.img} /> 
        <p>{prop.desc}</p>
        {/* <a href="/character" className="feature-link">Make Your Character</a> */}
    </div>
  )
}

export default Cards;