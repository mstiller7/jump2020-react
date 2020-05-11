import React, { Component } from 'react';
import { Container } from 'semantic-ui-react';
import ProductCard from './ProductCard';

export default class Product extends Component {

  // Function to render a ProductCard for each product Object.
  renderProductCards() {
    return this.props.products.map(product => {
      return <ProductCard key={product.id} details={product} />
    })
  }

  // Required function to render anything at all for this component.
  render() {
    return (
      <div>
        <Container>
          {this.renderProductCards()};
        </Container>
      </div>
    );
  }
}