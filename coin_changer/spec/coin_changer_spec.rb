require 'rspec'

require_relative '../lib/coin_changer'

describe CoinChanger do
  it 'converts 1 cent into 1 penny' do
    expect(CoinChanger.new.make_change(1)).to eq({ pennies: 1 })
  end

  it 'converts 2 cents into 2 pennies' do
    expect(CoinChanger.new.make_change(2)).to eq({ pennies: 2 })
  end

  it 'converts 5 cents into 1 nickel' do
    expect(CoinChanger.new.make_change(5)).to eq({ nickels: 1 })
  end

  it 'converts 6 cents into 1 nickel and 1 penny' do
    expect(CoinChanger.new.make_change(6)).to eq({
      nickels: 1, pennies: 1
    })
  end

  it 'converts 10 cents into 1 dime' do
    expect(CoinChanger.new.make_change(10)).to eq({
      dimes: 1
    })
  end

  it 'converts 25 cents into 1 quarter' do
    expect(CoinChanger.new.make_change(25)).to eq({
      quarters: 1
    })
  end

  it 'converts 26 cents into 1 quarter and one penny' do
    expect(CoinChanger.new.make_change(26)).to eq({
      quarters: 1,
      pennies: 1
    })
  end

  it 'converts 67 cents into 1 quarter' do
    expect(CoinChanger.new.make_change(67)).to eq({
      quarters: 2,
      dimes: 1,
      nickels: 1,
      pennies: 2,
    })
  end
end
