const React = require('react-native');

const { StyleSheet } = React;
import theme from '../../theme/light';

module.exports = StyleSheet.create({
  container: {
    padding: 20,
    flexDirection: 'column',
  },
  ic_left_input: {
    color: theme.primaryColor
  },
  input: {
    marginBottom: 10
  },
  row_sign_in_container: {
    flexDirection: 'row',
    justifyContent: 'flex-end',
    alignItems: 'flex-end',
    marginBottom: 10
  },
  txt_forget_pass: {
    marginBottom: 10,
    marginRight: 10,
    fontSize: 12
  },
  btn_sign_in: {
    alignSelf: 'flex-end',
    marginBottom: 10
  },
  row_sign_up_container: {
    flexDirection: 'row',
    justifyContent: 'center',
    marginBottom: 10
  },
  txt_sign_up: {
    color: theme.primaryColor,
    marginLeft: 5,
    fontSize: 16
  },
  btn_sign_in_fb: {
    backgroundColor: "#3b5998",
  },
  btn_sign_in_gg: {
    backgroundColor: "#df4a32"
  },
});
