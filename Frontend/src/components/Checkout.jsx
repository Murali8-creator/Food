import { useContext } from "react";
import { CartContext } from "../context/cart-context";

export const Checkout = ({ total, closeModal ,onSubmitted}) => {

  const {cartItems} = useContext(CartContext);
    
    const url = "http://localhost:8080/order";

    async function handleSubmitClick(event){
        event.preventDefault();

        const fd = new FormData(event.target);
        const customer = new Object();

        customer.name=fd.get('name');
        customer.email=fd.get('email');
        customer['phone']=fd.get('phone');
        customer.address=fd.get('address');

        // const order = new Object();
        // order.customer = customer;
        customer.cartItems = cartItems;

        // const data = new Object();

        // data.order = order;

        console.log(customer);
        
        let stringData = JSON.stringify(customer);
        console.log(stringData);
        fetch(url, {
            method : 'POST',
            body : stringData,
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
              }
        })
        .then(response => {
            if(!response.ok)
                throw new Error('..');
            return response.text()
        })
        .then(response => console.log(response))

        onSubmitted(true);
      }

  return (
    <>
      <form className='control' onSubmit={handleSubmitClick}>
        <h1>Checkout</h1>
        <p>Total Amount : ${total}</p>
        <label htmlFor=''>Full Name </label>
        <input type='text' name='name'/>
        <label htmlFor=''>Email Address </label>
        <input type='email' name='email'/>
        <label htmlFor=''>Street </label>
        <input type='text' name='street'/>
      <div className='control-row mt-4 mb-4'>
        <label htmlFor=''>Phone Number </label>
        <input type='number' name='phone'/>
        <label htmlFor=''>Address </label>
        <input type='text' name='address'/>
        </div>

        <div className='flex gap-5 space-x-10'>
        <button className='button'>Submit</button>
        <button className='button' type='button' onClick={closeModal}>Close</button>
        </div>
      </form>
    </>
  );
};


