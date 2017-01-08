import React, {Component} from 'react';
import {View,  TouchableOpacity} from 'react-native';
import { Container, Header, Title, Text, Content, Footer, FooterTab, Button } from 'native-base';
import styles from './styles';
import Icon from 'react-native-vector-icons/FontAwesome';
export default class CategoriesItem extends Component {
  render() {
         return (
           <TouchableOpacity style={styles.container}>
             <Icon name={this.props.icon} style={styles.ic_categories}/>
             <Text>
               {this.props.title}
             </Text>
           </TouchableOpacity>
         );
     }
 }
CategoriesItem.propType ={
  icon: React.PropTypes.string.isRequired,
  title: React.PropTypes.string.isRequired
}
