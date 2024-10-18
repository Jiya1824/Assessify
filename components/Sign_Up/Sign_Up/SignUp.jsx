import React, { useState } from 'react';
import './signup.css';
// import signup from '';
// import { Link } from "react-router-dom";


function SignUp() {
  // const googleAuth = () => {
  //   window.open(
  //       ${process.env.REACT_APP_API_URL}/auth/google/callback, "_self"
  //   );
// };
    function handleForm(){
        console.log("how");
    }
  const [username, setUserName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setpassword] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");
  const [title, setTitle] = useState("");

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setUserName (e.target.value);
  };
  const handleChange1 = (e) => {
    setEmail (e.target.value);
  };
  const handleChange2 = (e) => {
    setpassword (e.target.value);
  };
  const handleChange3 = (e) => {
    setconfirmPassword (e.target.value);
  };

// function handleForm(event){
//     event.preventDefault();
//     let storyData = {
//       userName:username,
//       userEmail:email,
//       userPassword:password
//     }
//     fetch("http://localhost:5000/signUp",{
//       method:'post',
//       storyData,
//       headers:{
//         "Content-Type":"multipart/form-data",
//         "Content-Type":"application/json"
        
//       },
//       body:JSON.stringify(storyData)
//     }).then(response=>response.json()).then(data=>{
//       console.log(data);
//     })
//     setUserName("");
//     setEmail("");
//     setpassword("");
//     setconfirmPassword("");
//     // setStory("");
//     console.log("Clicked")
//   }
  // function handleSubmit(event) {
  //   event.preventDefault();
  //   console.log(username);
  
  //   let formData2 = new FormData();
  //   formData2.append("storyTitle", title);
  //   formData2.append("userName", username);
  //   formData2.append("userEmail", email);
  //   formData2.append("userPassword", password);
  //   console.log(formData2.get("storyTitle"));

  
  //   fetch("http://localhost:5000/signUp", {
  //     method: 'POST',
  //     body: formData2,
      
  //   })
  //   .then(response => {
  //     console.log("done");
  //     if (!response.ok) {
  //       throw new Error(`HTTP error! Status: ${response.status}`);
  //     }
  //     return response.json();
  //   })
  //   .then(data => {
  //     console.log(data);
  //   })
  //   .catch(error => {
  //     console.error('Error:', error);
  //   });
  // }
  return (
    <div className='SignUp'>
      <h1 className='signup_title'>Exciting Stories Await! Join PlotPlus</h1>
      <div className='wrapper_signup'>
        <div className='left_signup'>
          <div className='signup_pic'>
            <img  alt='signup' />
          </div>
        </div>
        <div className='center'>
          <div className='line' />
        </div>
        <div className='right_signup'>
          <form onSubmit={handleForm}>
            <label>
              {/* Username: */}
              <input type='text' className="input_signup" placeholder='Name' name='username' onChange={handleChange}   value={username} />
            </label>
              {/* {errors.username && <span className='error'>{errors.username}</span>} */}
            <br />
            <label>
              {/* Email: */}
              <input type='text' className="input_signup" placeholder='email@gmail.com' name='email' onChange={handleChange1} value={email}/>
            </label>
              {/* {errors.email && <span className='error'>{errors.email}</span>} */}
            <br />
            <label>
              {/* Password: */}
              <input type='password' className="input_signup" placeholder='Password' name='password' onChange={handleChange2} value={password}  />
            </label>
              {/* {errors.password && <span className='error'>{errors.password}</span>} */}
            <br />
            <label>
              {/* Confirm Password: */}
              <input type='password' className="input_signup" placeholder='Confirm Password' name='confirmPassword' onChange={handleChange3} value={confirmPassword}/>
            </label>
              {/* {errors.confirmPassword && <span className='error'>{errors.confirmPassword}</span>} */}
            <br />
            {/* <button className='submit-btn color-blue'>Submit</button> */}
            <a href="/login" onClick={handleForm}><input  className='submit-btn color-blue' type="submit" value="SUBMIT"/></a>
          </form>
          <p>Been Here Before?{' '}
                {/* <Link to="/login" className="login-link">
                Log in and Continue Your Story!
                </Link> */}
                </p>
        </div>
      </div>
    </div>
  );
}

export default SignUp;