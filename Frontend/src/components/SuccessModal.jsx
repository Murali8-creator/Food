import React, { useContext } from 'react'
import { CartContext } from '../context/cart-context';
import axios from 'axios';

export const SuccessModal = ({closeModal}) => {
  const cartCtxValue = useContext(CartContext);
  
    function handleCloseClick(){
        cartCtxValue.clearCart();
         axios.get("http://localhost:8080/clearCart");
        closeModal();
    }
  return (
    <>
    <h1>Order Created Successfully</h1>
    <button onClick={handleCloseClick} className='button'>Close</button>
    </>
  )
}

