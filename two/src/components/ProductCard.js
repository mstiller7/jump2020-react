import React from 'react';
import { Card, Icon, Image } from 'semantic-ui-react';

const ProductCard = (props) => {  
  return (
    <Card>
      <Image src='https://i.imgur.com/XQuadax.jpg'/>
      <Card.Content>
        <Card.Header>
          <span className="itemname">{props.details.name}</span>
          </Card.Header>
        <Card.Meta>
          <span>Product ID: {props.details.id}</span>
        </Card.Meta>
        <Card.Description>
          <span><Icon name="dollar"/>{props.details.price}</span>
          <br/>
          <span>{props.details.description}</span>
        </Card.Description>
      </Card.Content>
    </Card>
  );
}

export default ProductCard;