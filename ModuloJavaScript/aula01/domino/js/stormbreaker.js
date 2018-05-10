class TestAssertionFailedError extends Error {
	constructor(message) {
		super(message)
	}
}

class TestAssertion {
	equals(expected, obtained) {
		if (expected !== obtained) {
			throw new TestAssertionFailedError(`expected: ${expected}, obtained: ${obtained}`)
		}
	}

	isTrue(obtained) {
		if (obtained !== true) {
			throw new TestAssertionFailedError(`expected: true, obtained: ${obtained}`)
		}
	}

	isFalse(obtained) {
		if (obtained !== false) {
			throw new TestAssertionFailedError(`expected: false, obtained: ${obtained}`)
		}
	}

	throws(errorClass, methodHandler) {
		try {
			methodHandler()
			throw 'test_failed'
		} catch (error) {
			if (error === 'test_failed') {
				throw new TestAssertionFailedError(`method not raise ${errorClass.name} error.`)
			}

			if (error instanceof errorClass === false) {
				throw new TestAssertionFailedError(
					`expected error class: ${errorClass.name}, obtainet ${
					error.constructor.name
					}`
				)
			}

			return error
		}
	}

	throwsWithMessage(errorClass, errorMessage, methodHandler) {
		const errorThrowed = this.throws(errorClass, methodHandler)

		if (errorThrowed.message !== errorMessage) {
			throw new Error(`expected message: "${errorMessage}", obtained message: "${errorThrowed.message}"`)
		}
	}
}

function test(testName, testMethod) {
	try {
		testMethod(new TestAssertion())
		console.log(`%c SUCCESS: ${testName}`, 'color: green')
	} catch (error) {
		console.log(`%c ERROR: ${testName} | ${error.message}`, 'color: red')
	}
}