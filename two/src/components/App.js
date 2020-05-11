import '../styles.css';
import React, { Component } from 'react';

// Extraneous UI components.
import Header from './Header';

// Project-specific class files and data.
import Product from './Product';
import StationaryProducts from '../data/StationaryProducts';

// =================================================================

// Default component, from index.js.
export default class App extends Component {

  state = {
    products: StationaryProducts
  }

  render() {
    return (
      <div>
        <Header />
        <Product products={this.state.products}/>
      </div>
    );
  }

}