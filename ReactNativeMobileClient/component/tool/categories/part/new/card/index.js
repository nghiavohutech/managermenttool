import React, {Component} from 'react';
import {Image, View} from 'react-native'
import { Container, Thumbnail, Card, CardItem, Header, Title, Text, Content, Footer, FooterTab, Button } from 'native-base';
import styles from './styles';
import Icon from 'react-native-vector-icons/FontAwesome';
export default class NewCard extends Component {
render() {
       return (
         <Container>
           <Content>
             <Card>
                 <CardItem>
                     <Text>{this.props.title}</Text>
                     <View style={styles.row_container}>
                       <Text note>{this.props.souce}</Text>
                       <Text note>{this.props.dateTime}</Text>
                     </View>
                 </CardItem>

                 <CardItem>
                   <Image style={{ resizeMode: 'cover', width: null }} source={{uri: this.props.imageUrl}}/>
                 </CardItem>
                 
                 <CardItem>
                   <Text>{this.props.shortDescription}</Text>
                 </CardItem>
            </Card>
           </Content>
         </Container>
       );
   }
}
NewCard.propType ={
  title: React.PropTypes.string.isRequired,
  souce: React.PropTypes.string.isRequired,
  dateTime: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,
  shortDescription: React.PropTypes.string.isRequired
}
