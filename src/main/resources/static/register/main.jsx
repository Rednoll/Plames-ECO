import React from 'react';
import ReactDOM from 'react-dom';
import TextField from "@material-ui/core/TextField";
import { withStyles } from "@material-ui/core/styles";
import { createMuiTheme, ThemeProvider } from '@material-ui/core/styles';

import styles from "./jss_styles.js";
import mainTheme from "../common/jss_styles.jsx";

let registerForm = null;

const emailValidateRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

const nicknameValidateRegex = /^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d]{3,16}$/;

const loginValidateRegex = /^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-_]{3,16}$/;

const emailValidator = (e) => {

	let email = e.target.value;

	if(email.match(emailValidateRegex)) {

		registerForm.setState({

			emailValid: true,
			emailHelperText: ""
		});
	}
	else {

		registerForm.setState({

			emailValid: false,
			emailHelperText: "Email incorrect!"
		});
	}
};

const nicknameValidator = (e) => {

	let nickname = e.target.value;

	if(nickname.match(nicknameValidateRegex)) {

		registerForm.setState({

			nicknameValid: true,
			nicknameHelperText: ""
		});
	}
	else {

		registerForm.setState({

			nicknameValid: false,
			nicknameHelperText: "Nickname incorrect! Only latin letters and numbers. 3-16 chars."
		});
	}
};

const loginValidator = (e) => {

	let login = e.target.value;

	if(login.match(loginValidateRegex)) {

		registerForm.setState({

			loginValid: true,
			loginHelperText: ""
		});
	}
	else {

		registerForm.setState({

			loginValid: false,
			loginHelperText: "Login incorrect! Only latin letters and numbers. 3-16 chars."
		});
	}
};

const passValidator = (e) => {

	let pass = document.querySelector("#pass-field").value;
	let passRe = document.querySelector("#pass-re-field").value;

	if(pass.localeCompare(passRe) == 0) {

		registerForm.setState({

			passReValid: true,
			passReHelperText: ""
		});
	}
	else {

		registerForm.setState({

			passReValid: false,
			passReHelperText: "Passwords not equals!"
		});
	}
};

class RegisterForm extends React.Component {

	constructor(props) {
		super(props);

		this.state = {

			nicknameValid: true,
			nicknameHelperText: "",
			loginValid: true,
			loginHelperText: "",
			emailValid: true,
			emailHelperText: "",
			passValid: true,
			passHelperText: "",
			passReValid: true,
			passReHelperText: "",
			showPass: false
		};
		
		registerForm = this;
	}

	render() {

		const { classes } = this.props;

		return (

			<form id="register-form" name="register-form" action="#" method="POST" modelAttribute="registerForm">

				<img id="register-plames-icon" src="../resources/common/images/plames-color-icon.svg"></img>

				<div id="register-form-fields-container">

					<ThemeProvider theme={mainTheme}>
						
						<TextField fullWidth id="nickname-field" name="nickname" onChange={nicknameValidator} InputProps={{ classes: { input: classes.registerFormFieldInput } }} className={classes.registerFormField} error={!this.state.nicknameValid} helperText={this.state.nicknameHelperText} label="Nickname" />

						<TextField fullWidth id="login-field" name="login" onChange={loginValidator} InputProps={{ classes: { input: classes.registerFormFieldInput } }} className={classes.registerFormField} error={!this.state.loginValid} helperText={this.state.loginHelperText} label="Login" />

						<TextField fullWidth id="email-field" name="email" onChange={emailValidator} color="#BAE1FF" InputProps={{ classes: { input: classes.registerFormFieldInput } }} className={classes.registerFormField} error={!this.state.emailValid} helperText={this.state.emailHelperText} label="Email" />
						
						<TextField fullWidth id="pass-field" name="pass" onChange={passValidator} InputProps={{ classes: { input: classes.registerFormFieldInput } }} className={classes.registerFormField} error={!this.state.passValid} helperText={this.state.passHelperText} label="Password" type={this.state.showPass ? "text" : "password"} />
						
						<TextField fullWidth id="pass-re-field" onChange={passValidator} InputProps={{ classes: { input: classes.registerFormFieldInput } }} className={classes.registerFormField} error={!this.state.passReValid} helperText={this.state.passReHelperText} label="Re-enter" type={this.state.showPass ? "text" : "password"} />
					
					</ThemeProvider>

				</div>

			</form>
		);
	}
}

const StyledRegisterForm = withStyles(styles)(RegisterForm);

ReactDOM.render(<StyledRegisterForm />, document.querySelector("#register-form-container"));