class CoinChanger

  CONVERSIONS = {
    quarters: 25,
    dimes: 10,
    nickels: 5,
    pennies: 1
  }

  def make_change(cents)
    change = {}

    CONVERSIONS.each do |coin, value|
      while cents >= value
        change[coin] = change[coin].to_i + 1
        cents -= value
      end
    end

    return change
  end
end
