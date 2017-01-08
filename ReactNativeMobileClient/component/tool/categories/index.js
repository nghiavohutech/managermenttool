import React, {Component} from 'react';
import {View} from 'react-native'
import { Container, Header, Title, Text, Content, Footer, FooterTab, Button, Icon } from 'native-base';
import EIcon from 'react-native-vector-icons/Entypo';
import styles from './styles';
import CaterogiesItem from './item/index'

export default class ToolCategories extends Component {
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.row_container}>
          <CaterogiesItem icon='feed' title='Tin tức'/>
            <CaterogiesItem icon='cloud' title='Thời tiết'/>
              <CaterogiesItem icon='money' title='Tiền tệ'/>
        </View>
        <View style={styles.row_container}>
          <CaterogiesItem icon='dollar' title='Xổ số'/>
            <CaterogiesItem icon='diamond' title='Giá vàng'/>
              <CaterogiesItem icon='motorcycle' title='Giá xăng'/>
        </View>
      </View>
    );
     }
 }
