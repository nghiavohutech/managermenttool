import React, {Component} from 'react';
import {View} from 'react-native'
import { Container, Header, Title, Text, Content, Footer, FooterTab, Button, Icon } from 'native-base';
import styles from './styles';
import ToolCategories from './categories/index'
export default class ToolPaper extends Component {
render() {
       return (
         <Container>
           <Content>
             <ToolCategories/>
           </Content>
         </Container>
       );
   }
}
