import React, { useState } from 'react'
import google from '../../Assets/google.png';
import facebook from '../../Assets/facebook.png';
import github from '../../Assets/github.png';
import './login.css';
import './signup.css';
// import { Link, useNavigate } from "react-router-dom";
function Login() {
    function handleSubmit(){
        console.log("submit hogya bhai");
    }

    const [username , setUsername] =useState("hi");
    const [password, setPassword]=  useState("hi");
  return (
    <div className='login'>
        <h1 className='login_title'>Choose a Login Method</h1>
        <div className='wrapper'>
            <div className='left'>
                <div className='login_button google'>
                    <img src={google} alt="google" className='icons' />
                    Google
                </div>
                <div className='login_button facebook'>
                    <img src={facebook} alt="facebook" className='icons'/>
                    facebook
                </div>
                <div className='login_button github'>
                    <img src={github} alt="github" className='icons' />
                    Github
                </div>
            </div>
            <div className='center'>
                <div className='line'/>
                <div className='or'>OR</div>
            </div>
            <div className='right'>
                <input type='text' className="input_login" placeholder='Username' onChange={(e) => setUsername(e.target.value)}/>
                <input type='password' className="input_login" placeholder='Password' onChange={(e) => setPassword(e.target.value)}/>
                <button className='submit-btn color-blue' onClick={handleSubmit}>Submit</button>
                <p> Don't have an account?{' '}
                <a href="/signup" className="signup-link">
                Join the Adventure!
                </a>
                </p>
            </div>
        </div>
    </div>
  )
}

export default Login
